package problems;

public class BitArray {

	private int[] bitArr = null;
	
	public BitArray() {	}
	
	public BitArray(int size) {
		this.bitArr = new int[size];
	}

	public void init(int size) {
		this.bitArr = new int[size];
	}
	
	public boolean set(int i, int value) {
		
		if(i >= this.bitArr.length || i < 0) {
			return false;
		}
		if(value != 0 && value != 1) {
			return false;
		}

		this.bitArr[i] = value;
		
		return true;
	}
	
	public int get(int i) throws IndexOutOfBoundsException {
		if(i >= bitArr.length || i < 0) {
			throw new IndexOutOfBoundsException();
		}
		return this.bitArr[i];
	}
	
	public int size() {
		return this.bitArr.length;
	}
	
	public static void main(String[] args) {
		BitArray bitArr = new BitArray();
		
		bitArr.init(5);
		bitArr.set(2, 1);
		bitArr.set(0, 1);
		
		for(int i = 0; i < bitArr.size(); i++) {
			System.out.print(bitArr.get(i) + " ");
		}
		
	}
}
