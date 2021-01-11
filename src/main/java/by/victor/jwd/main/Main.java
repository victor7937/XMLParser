package by.victor.jwd.main;

import by.victor.jwd.service.ServiceFactory;
import by.victor.jwd.service.XMLParseService;

public class Main {

    public static void main(String[] args) {

        ServiceFactory factory = ServiceFactory.getInstance();
        XMLParseService service = factory.getXmlParseService();

        String treeView = service.getXMLTreeView();
        System.out.println(treeView);

        /*
        ----------------Output example---------------------
        breakfast-menu
        --food {id=1}
        ----name: Belgian Waffles
        ----choco: Yes
        ----sugar: Double
        ----price {currency=usd and eur}
        ------usd: $5.45
        ------eur: €4.3
        ----inStock: Yes
        --food {id=2}
        ----name: Strawberry Belgian Waffles
        ----price: $7.95
        ----inStock: No
        --food {id=3}
        ----name: Pineapple Waffles
        ----price: $2.72
        ----inStock: Yes
        --food {id=4}
        ----name: Spartak Waffles
        ----price: $0.45
        ----manufacturer {countryCode=375, producerId=738AD-56}
        ------country {name=Belarus}
        --------city: Minsk
        ----inStock: Yes

         */

    }

}
