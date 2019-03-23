package com.example.tableVaadinPostgreSQL;

import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class VaadinUI extends UI {

    @Autowired
    private CompanyService service;

    private Company company;

    private Grid<Company> grid = new Grid(Company.class);
    private TextField name = new TextField("Name");
    private TextField surname = new TextField("Surname");
    private TextField email = new TextField("Email");
    private Button save = new Button("Save", e -> saveCompany());
    private Button delete = new Button("Delete", e -> delete());
    private Button insert = new Button("Insert", e-> insertCompany());
    @Override
    protected void init(VaadinRequest request) {grid.setColumns("id","name","surname","email");
        updateGrid();
        grid.addSelectionListener(e -> updateForm());
        HorizontalLayout layout = new HorizontalLayout(new VerticalLayout(grid, new HorizontalLayout(delete, insert)), new VerticalLayout(name, surname, email, save));
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }

    private void updateGrid() {
        grid.setItems(service.findAll());
        setFormVisible(true);
    }

    Binder<Company> binder = new Binder<>(Company.class);
    private void updateForm() {
        setFormVisible(!grid.getSelectedItems().isEmpty());
        if (!grid.getSelectedItems().isEmpty()) {
            company = grid.asSingleSelect().getValue();
            binder.bindInstanceFields(this);
            binder.setBean(company);
        }
    }

    private void setFormVisible(boolean visible) {
        name.setVisible(visible);
        surname.setVisible(visible);
        email.setVisible(visible);
        save.setVisible(visible);
    }

    private void saveCompany() {
        service.update(company);
        updateGrid();
    }

    private void delete(){
        service.delete(company);
        updateGrid();
    }

    private void insertCompany(){
        Company newCompany=new Company();
        newCompany.setName(name.getValue());
        newCompany.setSurname(surname.getValue());
        newCompany.setEmail(email.getValue());

        service.insert(newCompany);

        updateGrid();
    }
}