import java.util.ArrayList;

// 상품 Controller 
public class ProductController {

	private static ProductController instance;
	private ArrayList<Product> product;

	private ProductController() {
		product = new ArrayList<>();
	}

	public ArrayList<Product> getProducts() {
		return product;
	}

	public static ProductController getInstance() {
		if (instance == null) {
			instance = new ProductController();
		}
		return instance;
	}

}
