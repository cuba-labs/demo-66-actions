package com.company.demo.web.product;

import com.haulmont.bali.util.ParamsMap;
import com.haulmont.cuba.gui.components.AbstractLookup;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.ButtonsPanel;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.components.actions.CreateAction;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import javax.inject.Named;
import java.time.LocalDate;
import java.util.Map;

public class ProductBrowse extends AbstractLookup {

    @Inject
    private ButtonsPanel buttonsPanel;
    @Inject
    private ComponentsFactory componentsFactory;

    @Named("productsTable.create")
    private CreateAction productsTableCreate;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        // BaseAction API

        Button demoBtn = componentsFactory.createComponent(Button.class);
        demoBtn.setAction(new BaseAction("demo")
                .withCaption("Demo")
                .withIcon("font-icon:BELL_O")
                .withHandler(e -> {
                    showNotification("Demo!");
                }));

        buttonsPanel.add(demoBtn);

        // initial data supplier

        productsTableCreate.setInitialValuesSupplier(() ->
                ParamsMap.of("title", "Today is " + LocalDate.now().getDayOfWeek().name())
        );
    }
}