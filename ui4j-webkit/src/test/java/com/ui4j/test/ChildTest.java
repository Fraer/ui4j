package com.ui4j.test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.ui4j.api.browser.BrowserEngine;
import com.ui4j.api.browser.BrowserFactory;
import com.ui4j.api.browser.Page;
import com.ui4j.api.dom.Document;
import com.ui4j.api.dom.Element;

public class ChildTest {

    @Test
    public void test() {
        BrowserEngine webkit = BrowserFactory.getWebKit();
        try (Page page = webkit.navigate(ChildTest.class.getResource("/ChildTest.html").toExternalForm())) {
            Document document = page.getDocument();
            List<Element> children = document.query("ul").get().getChildren();
            assertEquals(2, children.size());
            assertEquals("a", children.get(0).getText().get());
            assertEquals("b", children.get(1).getText().get());
        }
    }
}
