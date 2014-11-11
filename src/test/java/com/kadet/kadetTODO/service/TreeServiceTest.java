package com.kadet.kadetTODO.service;


import com.kadet.kadetTODO.util.Strings;
import com.kadet.kadetTODO.web.model.TreeEntityUI;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Date: 11.11.2014
 * Time: 10:56
 *
 * @author Alex Soroka
 */
public class TreeServiceTest {

    private TreeService treeService = new TreeService();

    @Test
    public void testTreeServiceOnNull () {
        Assert.assertNotNull(treeService.getTree());
    }

    @Test
    public void testGetErrorTree () {
        Assert.assertNotNull(treeService.getErrorTree());
    }

    @Test
    public void testTreeStructure () {
        // test root
        TreeEntityUI tree = treeService.getTree();
        Assert.assertEquals(Strings.ROOT_TEXT, tree.getText());
        Assert.assertEquals(2, tree.getChildren().size());
        // test myPage
        TreeEntityUI myPage = tree.getChildren().get(0);
        Assert.assertEquals(Strings.MY_PAGE_TEXT, myPage.getText());
        Assert.assertEquals(1, myPage.getChildren().size());
        // test tasks
        TreeEntityUI tasks = tree.getChildren().get(1);
        Assert.assertEquals(Strings.TASKS_TEXT, tasks.getText());
        Assert.assertEquals(1, tasks.getChildren().size());
    }


}
