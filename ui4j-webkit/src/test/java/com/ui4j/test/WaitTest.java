package com.ui4j.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ui4j.api.browser.BrowserEngine;
import com.ui4j.api.browser.BrowserFactory;
import com.ui4j.api.browser.BrowserType;
import com.ui4j.api.browser.Page;
import com.ui4j.api.dom.Document;

public class WaitTest {

    private static Document document;

    private static Page page;

    @BeforeClass public static void beforeTest() {
        BrowserEngine browser = BrowserFactory.getBrowser(BrowserType.WebKit);
        page = browser.navigate("https://news.ycombinator.com");
        page.show();
        document = page.getDocument();
    }

    @Test public void test() {
        Assert.assertEquals("Hacker News", document.getTitle().get());
        document.query("a[href='https://github.com/HackerNews/API']").get().click();
        Assert.assertEquals(document.getTitle().get(), "HackerNews/API · GitHub");
        page.close();
    }
}
