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
    private Button save = new Button("Save");
    private Button delete = new Button("Delete");
    private Button addNew = new Button("Insert");
    @Override
    protected void init(VaadinRequest request) {grid.setColumns("id","name","surname","email");
        updateGrid();
        grid.addSelectionListener(e -> updateForm());
        HorizontalLayout layout = new HorizontalLayout(new VerticalLayout(grid, new HorizontalLayout(delete, addNew)), new VerticalLayout(name, surname, email, save));
        layout.setMargin(true);
        layout.setSpacing(true);
        setContent(layout);
    }

    private void updateGrid() {
        grid.setItems(service.findAll());
    }

    Binder<Company> binder = new Binder<>(Company.class);
    private void updateForm() {
        if (!grid.getSelectedItems().isEmpty()) {
            company = grid.asSingleSelect().getValue();
            binder.bindInstanceFields(this);
            binder.setBean(company);
        }
    }

    private void saveCompany() {
        service.save(company);
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

        service.save(newCompany);

        updateGrid();
    }
}