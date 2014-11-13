package com.kadet.kadetTODO.util.extjs;

import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.web.to.TreeEntityTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Alex Soroka
 */
public class TreeEntityBuilderTest {

    /**
     *  Right Structure:
     *  -- Root
     *     |
     *     -- My Page
     *     -- Tasks
     */
    @Test
    public void shouldHasRightStructure () {

        // init
        TreeEntityBuilder treeEntityBuilder = new TreeEntityBuilder();

        // test root
        TreeEntityTO root = treeEntityBuilder.build();
        Assert.assertEquals(Strings.ROOT_TEXT, root.getText());
        Assert.assertEquals(2, root.getChildren().size());

        // test myPage
        TreeEntityTO myPage = root.getChildren().get(0);
        Assert.assertEquals(Strings.MY_PAGE_TEXT, myPage.getText());
        Assert.assertEquals(1, myPage.getChildren().size());

        // test tasks
        TreeEntityTO tasks = root.getChildren().get(1);
        Assert.assertEquals(Strings.TASKS_TEXT, tasks.getText());
        Assert.assertEquals(1, tasks.getChildren().size());
    }

}
