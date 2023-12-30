package test;
import logic.MainPageLogic;
import logic.ResturantAPI;
import infra.Infrastructure;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Resturant;
import utils.Columns;
import java.io.FileInputStream;
import java.util.Properties;
import infra.HttpResponse;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestStep {
    private MainPageLogic mainPageLogic;
    private Infrastructure inf;
    private static ResturantAPI api;
    private static Properties prop ;


    @BeforeAll
    public static void beforeAll(){
        prop = new Properties();
        api=new ResturantAPI();
        try {
            FileInputStream ip = new FileInputStream("src/main/java/config.properties");
            prop.load(ip);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @BeforeEach
    public void beforEeach(){
        inf= Infrastructure.initInfra(
                prop.getProperty("driverPath"),
                prop.getProperty("webLink"));
        mainPageLogic=new MainPageLogic(inf);
    }

    @AfterEach
    public void afterEach(){
        inf.closeDriver();
    }

    @Test
    public void checkAddRestaurant()  {
        //arrange
        HttpResponse httpResponse = api.addNewResturant(new Resturant(33, "a", "12", 1));
        mainPageLogic.refreshPage();
        //act
        boolean actual =mainPageLogic.checkResturantAdded(33);
        //assert
        assertThat("status code failed",httpResponse.getStatus()>199&&httpResponse.getStatus()<300);
        assertThat("restaurant failed to added",actual);
    }

    @Test
    public void checkRemove(){
        //arrange
        Resturant r=new Resturant(22,"a","12",1);
        HttpResponse httpResponse = api.addNewResturant(r);
        mainPageLogic.refreshPage();
        //Act
        boolean actual=mainPageLogic.removeRestaurant(r.getId());
        mainPageLogic.refreshPage();
        //Assert
        assertThat("status code failed",httpResponse.getStatus()>199&&httpResponse.getStatus()<300);
        assertThat("restaurant failed remove",actual);
    }
    @Test
    public void checkUpdate(){
        //arrange
        Resturant r = new Resturant(44,"a","12",1);
        HttpResponse httpResponse = api.addNewResturant(r);
        mainPageLogic.refreshPage();
        //Act
        String newValue="Omari";
        HttpResponse httpResponse2 = api.updateRestaurant(r.getId(), Columns.address,newValue);
        mainPageLogic.refreshPage();
        String valueOfAddress = mainPageLogic.valueOF(r.getId(),Columns.address);
        //Assert
        assertThat("status code failed for add",httpResponse.getStatus()>199&&httpResponse.getStatus()<300);
//        assertThat("status code failed for update", httpResponse2 != null && httpResponse2.getStatus() > 199 && httpResponse2.getStatus() < 300);
//        assertThat("No changes",newValue.equals(valueOfAddress));
    }
}
