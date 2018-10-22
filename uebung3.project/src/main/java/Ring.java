public class Ring {

    // inner class: groups data value and prev/next "pointer"
	class Item {
        int value;
        Item prev;
        Item next;

        Item(int v) {
            value = v;
            prev = null;
            next = null;
        }
    }

	// "first" element of ring, anchor
	private Item first;

	// create empty ring
	public Ring() {
		first = null;
	}

	// check if ring is empty
	public boolean isEmpty() {
		return first == null;
	}

	// check if element is "first" anchor element
	public boolean isFirst(Item item) {
		return item == first;
	}

	// return "first" anchor element
	public Item getFirst() {
		return first;
	}

	// return element that succeeds "item"
	public Item getNext(Item item) {
		return item.next;
	}

	// add element with value "val" to THIS ring in front of "first"/anchor element
	// leave first element / anchor unchanged.
	public void append(int val)
	{
		Item newItem = new Item(val);

		if(first == null)
		{
			first = newItem;
		}
		else if(first.next == null)
		{
			first.next = newItem;
			first.prev = newItem;
			newItem.prev = first;
			newItem.next = first;
		}
		else
		{
			newItem.next = first;
			newItem.prev = first.prev;

			first.prev.next = newItem;
			first.prev = newItem;
		}
	}
	
	// removes items [a..b] from THIS ring and returns removed ring
	// Assumption: a..b does not include anchor/first element
	public Ring split(Item a, Item b) {

		Ring ring = new Ring();
		if(b.next == a)
		{
			ring.first = first;
			first = null;
		}
		else
		{
			a.prev.next = b.next;
			b.next.prev = a.prev;

			ring.first = a;
			a.prev = b;
			b.next = a;
		}

		return ring;
	}


	public String toString() {
		if (first == null) {
			return "";
		} else {
			String back = "";
			Item pos = first;
			do {
				back = back + pos.value;
				pos = pos.next;
				if (pos != first)
					back = back + " ";
			} while (pos != first);
			return back; 
		}
	}

	// Testet die Implementierung 
	public static void main(String args[]) {
		// Erzeuge Ring mit den Elementen 1..8 
		Ring r = new Ring();
		r.append(1);
		r.append(2);
		r.append(3);
		r.append(4);
		r.append(5);
		r.append(6);
		r.append(7);
		r.append(8);
		System.out.println("Erzeugter Ring:  r = " + r.toString());
		System.out.println("Erwartet:        r = 1 2 3 4 5 6 7 8\n");
	
		
		// Trenne den Teilring 3..6 vom Ring r ab und speichere in R2
		Item pos3 = r.getNext(r.getNext(r.getFirst()));
		Item pos6 = r.getNext(r.getNext(r.getNext(pos3)));
		Ring r2 = r.split(pos3, pos6);
		System.out.println("Teilring r2 (=" + r2.toString() + ") wird abgetrennt -> r = " + r.toString());
		System.out.println("Erwartet: r = 1 2 7 8\n");
		

	}



}
