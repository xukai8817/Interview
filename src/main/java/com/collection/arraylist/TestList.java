package com.collection.arraylist;

import java.util.Collection;
import java.util.List;

/**
 * @moudle: TestList 
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年5月13日 下午3:00:56
 *
 */ 
public class TestList {

	private int si;
	
	public TestList() {
		List<String>  strList = new java.util.ArrayList<>();
		Collection<String>  strCollection = new java.util.ArrayList<>();
		strList.add("a");
		strList.add("b");
		strList.add("c");
//		strCollection.add("c");
//		batchRemove(strCollection, false, strList);
		strCollection.add("d");
		batchRemove(strCollection, true, strList);
	}
	
	public static void main(String[] args) {
		TestList test = new TestList();
		System.out.println(test.getSize());
		int[] a=new int[5];
		System.out.println(a[0] + "," +a[1] + "," +a[2] + "," +a[3] + "," +a[4]);
		
		List<String> str = new java.util.ArrayList<>();
		Object[] strarray = (Object[]) str.toArray();
		System.out.println(strarray);
		
		Integer[] integer = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int fromIndex = 5;
		int toIndex = 9;
		int numMoved = integer.length - toIndex;
		System.arraycopy(integer, toIndex, integer, fromIndex ,numMoved);
		int newSize = integer.length - (toIndex - fromIndex);
		for(int i = newSize;i < integer.length; i++) {
			integer[i] = null;
		}
		for (int i = 0; i < integer.length; i++) {
			System.out.println(integer[i]);
		}
		
		
	}
	
	private int getSize() {
		return si;
	}
	
    private  boolean batchRemove(Collection<?> c, boolean complement, List<?>  list) {
        final Object[] elementData = list.toArray();
        int size = list.size();
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++)
                if (c.contains(elementData[r]) == complement){
                	elementData[w] = elementData[r];
                	System.out.println("w=" + w + ",r=" + r);
                	w++;
                }
        } finally {
            // Preserve behavioral compatibility with AbstractCollection,
            // even if c.contains() throws.
            if (r != size) {
                System.arraycopy(elementData, r,
                                 elementData, w,
                                 size - r);
                w += size - r;
            }
            if (w != size) {
                // clear to let GC do its work
                for (int i = w; i < size; i++)
                    elementData[i] = null;
                size = w;
                modified = true;
                for (int i = 0; i < elementData.length; i++) {
					System.out.print(elementData[i] + " ");
				}
                System.out.println();
            }
        }
        return modified;
    }

}
