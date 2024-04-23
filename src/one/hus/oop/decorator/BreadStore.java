package one.hus.oop.decorator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BreadStore {
	private List<Bread> breads;

	public BreadStore() {
		breads = new LinkedList<>();
	}

	/**
	 * Giả sử bánh mỳ được làm không cho một loại gia vị nhiều hơn một lần.
	 * Bắt đầu, tạo ra và cho vào cửa hàng:
	 *  5 bánh mỳ ThickcrustBread chỉ có cheese,
	 *  5 bánh mỳ ThickcrustBread chỉ có olives,
	 *  5 bánh mỳ ThickcrustBread có cả cheese và olives,
	 *  5 bánh mỳ ThincrustBread chỉ có cheese,
	 *  5 bánh mỳ ThincrustBread chỉ có olives,
	 *  5 bánh mỳ ThincrustBread có cả cheese và olives.
	 */
	public void init() {
		for (int i = 0; i < 5; i++) {
			Bread thickcrustBreadCheese = new ThickcrustBread();
			thickcrustBreadCheese = new Cheese(thickcrustBreadCheese);
			breads.add(thickcrustBreadCheese);

			Bread thickcrustBreadOlives = new ThickcrustBread();
			thickcrustBreadOlives = new Olives(thickcrustBreadOlives);
			breads.add(thickcrustBreadOlives);

			Bread thickcrustBreadCheeseOlives = new ThickcrustBread();
			thickcrustBreadCheeseOlives = new Cheese(thickcrustBreadCheeseOlives);
			thickcrustBreadCheeseOlives = new Olives(thickcrustBreadCheeseOlives);
			breads.add(thickcrustBreadCheeseOlives);

			Bread thincrustBreadCheese = new ThincrustBread();
			thincrustBreadCheese = new Cheese(thincrustBreadCheese);
			breads.add(thincrustBreadCheese);

			Bread thincrustBreadOlives = new ThincrustBread();
			thincrustBreadOlives = new Olives(thincrustBreadOlives);
			breads.add(thincrustBreadOlives);

			Bread thincrustBreadCheeseOlives = new ThincrustBread();
			thincrustBreadCheeseOlives = new Cheese(thincrustBreadCheeseOlives);
			thincrustBreadCheeseOlives = new Olives(thincrustBreadCheeseOlives);
			breads.add(thincrustBreadCheeseOlives);
		}
	}

	/**
	 * Thêm bánh mỳ vào cửa hàng.
	 */
	public void add(Bread bread) {
		breads.add(bread);
	}

	/**
	 * Giả sử cửa hàng bán một cái bánh mỳ nào đó,
	 * Bánh mỳ được lấy ra để bán là bánh mỳ đầu tiên có giá bằng giá
	 *  bánh mỳ yêu cầu.
	 * Nếu còn bánh mỳ để bán thì trả về giá trị true,
	 *  nếu không còn trả về giá trị false.
	 */
	public boolean sell(Bread bread) {
		for (int i = 0; i < breads.size(); i++) {
			if (breads.get(i).cost() == bread.cost()) {
				System.out.println("Sold: " + breads.get(i).getDescription() + " at $ " + breads.get(i).cost());
				breads.remove(i);
				return true;
			}
		}
		System.out.println("No bread left of that type");
        return false;
    }

	/**
	 * In ra những bánh mỳ còn trong cửa hàng.
	 */
	public void print() {
		for (Bread bread : breads) {
			System.out.println(bread.getDescription());
		}
	}

	/**
	 * Sắp xếp các bánh mỳ còn lại theo thứ tự được cho bởi order,
	 * nếu order là true, sắp xếp theo thứ tự tăng dần,
	 * nếu order là false, sắp xếp theo thứ tự giảm dần.
	 * Việc sắp xếp không làm thay đổi thứ tự của bánh mỳ trong cửa hàng.
	 */
	public List<Bread> sort(boolean order) {
		List<Bread> toSort = new ArrayList<>(breads);
		toSort.sort(order ? Comparator.comparingDouble(Bread::cost) : 
				Comparator.comparingDouble(Bread::cost).reversed());
        return toSort;
    }

	/**
	 * Lọc ra howMany cái bánh mỳ có giá cao nhất hoặc thấp nhất,
	 * nếu order là true thì lọc ra bánh mỳ có giá cao nhất,
	 * nếu order là false thì lọc ra bánh mỳ có giá thấp nhất.
	 */
	public List<Bread> filter(int howMany, boolean order) {
		List<Bread> toFilter = sort(order);
        return toFilter.stream().limit(howMany).toList();
    }

	public static void main(String args[]) {

		/*
		* Sau khi khởi tạo số bánh mỳ cho cửa hàng, viết chương trình demo:
		* - Thêm một số bánh mỳ vào cửa hàng
		* - Bán một số bánh mỳ từ cửa hàng
		* - In ra số bánh mỳ còn lại theo thứ tự giá tăng dần.
		* - In ra nhiều nhất 10 cái bánh mỳ có giá thấp nhất còn trong cửa hàng.
		*/
		/* TODO */
		// Grand opening
		BreadStore breadStore = new BreadStore();
		breadStore.init();

		Bread thincrustBreadOlives = new ThincrustBread();
		thincrustBreadOlives = new Olives(thincrustBreadOlives);

		Bread thincrustBreadCheese = new ThincrustBread();
		thincrustBreadCheese = new Cheese(thincrustBreadCheese);

		Bread thickcrustBreadCheese = new ThickcrustBread();
		thickcrustBreadCheese = new Cheese(thickcrustBreadCheese);

		Bread thickcrustBreadOlives = new ThickcrustBread();
		thickcrustBreadOlives = new Olives(thickcrustBreadOlives);

		// Adding some breads
		breadStore.add(thincrustBreadOlives);
		breadStore.add(thickcrustBreadOlives);
		breadStore.add(thickcrustBreadCheese);
		breadStore.add(thincrustBreadCheese);

		// Selling some breads
		System.out.println("Store in business: ");
		breadStore.sell(thincrustBreadOlives);
		breadStore.sell(thickcrustBreadOlives);
		breadStore.sell(thickcrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);
		breadStore.sell(thincrustBreadCheese);

		List<Bread> sorted = breadStore.sort(true);

		// Printing out breads sorted by price increasing
		System.out.println("Printing out breads sorted by price increasing: ");
		for (Bread bread : sorted) {
			System.out.println(bread.getDescription() + " $ " + bread.cost());
		}

		// Cheapest 10 breads left
		System.out.println("Cheapest 10 breads left: ");
		List<Bread> filtered = breadStore.filter(10, true);
		for (Bread bread : filtered) {
			System.out.println(bread.getDescription() + " $ " + bread.cost());
		}
	}
}
