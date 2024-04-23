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
		List<Bread> batch_1 = new ArrayList<>();
		List<Bread> batch_2 = new ArrayList<>();
		List<Bread> batch_3 = new ArrayList<>();
		List<Bread> batch_4 = new ArrayList<>();
		List<Bread> batch_5 = new ArrayList<>();
		List<Bread> batch_6 = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			Bread bread1 = new ThickcrustBread();
			bread1 = new Cheese(bread1);
			batch_1.add(bread1);

			Bread bread2 = new ThickcrustBread();
			bread2 = new Olives(bread2);
			batch_2.add(bread2);

			Bread bread3 = new ThickcrustBread();
			bread3 = new Cheese(bread3);
			bread3 = new Olives(bread3);
			batch_3.add(bread3);

			Bread bread4 = new ThincrustBread();
			bread4 = new Cheese(bread4);
			batch_4.add(bread4);

			Bread bread5 = new ThincrustBread();
			bread5 = new Olives(bread5);
			batch_5.add(bread5);

			Bread bread6 = new ThincrustBread();
			bread6 = new Cheese(bread6);
			bread6 = new Olives(bread6);
			batch_6.add(bread6);
		}
		breads.addAll(batch_1);
		breads.addAll(batch_2);
		breads.addAll(batch_3);
		breads.addAll(batch_4);
		breads.addAll(batch_5);
		breads.addAll(batch_6);
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
				System.out.println("Sold: " + breads.get(i).getDescription() + " at " + breads.get(i).cost());
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
		if (order) {
			toSort.sort(Comparator.comparingDouble(Bread::cost));
		} else {
			toSort.sort(Comparator.comparingDouble(Bread::cost).reversed());
		}
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
		BreadStore breadStore = new BreadStore();
		breadStore.init();
		List<Bread> sorted = breadStore.sort(true);
		breadStore.print();
		for (Bread bread : sorted) {
			System.out.println(bread.getDescription() + " " + bread.cost());
		}
		Bread bread5 = new ThincrustBread();
		bread5 = new Olives(bread5);

		Bread bread6 = new ThincrustBread();
		bread6 = new Cheese(bread6);

		Bread bread1 = new ThickcrustBread();
		bread1 = new Cheese(bread1);

		Bread bread2 = new ThickcrustBread();
		bread2 = new Olives(bread2);

		breadStore.sell(bread5);
		breadStore.sell(bread2);
		breadStore.sell(bread1);
		breadStore.sell(bread6);
		breadStore.sell(bread6);
		breadStore.sell(bread6);
		breadStore.sell(bread6);
		breadStore.sell(bread6);
		breadStore.sell(bread6);

		breadStore.print();

		List<Bread> filtered = breadStore.filter(10, true);
		for (Bread bread : filtered) {
			System.out.println(bread.getDescription() + " " + bread.cost());
		}
	}
}
