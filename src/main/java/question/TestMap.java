package question;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @moudle: TestMap
 * @version:v1.0
 * @Description: TODO
 * @author: xukai
 * @date: 2017年6月9日 下午7:03:30
 *
 */
public class TestMap {

	public static void main(String[] args) {
		Map<String, String[]> map = new HashMap<>();
		map.put("1", new String[] { "wm", "chy" });
		map.put("2", new String[] { "wm", "him" });
		map.put("3", new String[] { "him", "chy" });

		Set<Map.Entry<String, String[]>> set = map.entrySet();
		Map<String, String> newMap = new HashMap<>();
		for (Iterator<Entry<String, String[]>> iterator = set.iterator(); iterator.hasNext();) {
			Entry<String, String[]> entry = (Entry<String, String[]>) iterator.next();
			String[] arrayStr = entry.getValue();
			String[] temp = Arrays.copyOf(arrayStr, arrayStr.length);
			for (int i = 0; i < arrayStr.length; i++) {
				if (newMap.containsKey(arrayStr[i])) {
					temp[i] = null;
					entry.setValue(temp);
				} else {
					newMap.put(arrayStr[i], entry.getKey());
				}
			}
		}
		System.out.println(print(map));
	}

	public static String print(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		Set<Map.Entry<String, String[]>> set = map.entrySet();
		for (Entry<String, String[]> entry : set) {
			sb.append(entry.getKey() + "=");
			sb.append("{");
			for (String str : entry.getValue()) {
				sb.append(str + " ");
			}
			sb.append("}" + " ");
		}
		return sb.toString();
	}
}
