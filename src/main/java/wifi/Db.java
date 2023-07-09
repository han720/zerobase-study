package wifi;

import java.util.*;

public class Db {

	public Map<String, DbWIFI> select (Double lat, Double lnt) {
		WiFiDate wifi = new WiFiDate();
		List<Double> list = new ArrayList<> ();
		Map<Double, DbWIFI> map = new HashMap<> ();
		
		for (DbWIFI w : wifi.list()) {
			double xLat = Math.pow(Math.abs(lat - Double.parseDouble(w.getLat())), 2);
			double yLnt = Math.pow(Math.abs(lnt - Double.parseDouble(w.getLnt())), 2);
			double s = Math.sqrt(xLat + yLnt);
			map.put(s, w);
			list.add(s);
		}
		
		list.sort(Comparator.naturalOrder());
		
		Map<String, DbWIFI> date = new HashMap<> ();
		
		int i = 0;
		while (i < 20) {
			date.put(String.valueOf(list.get(i)), map.get(list.get(i)));
			i++;
		}
		
		return date;
	}
	
	public static void main (String[] args) {
		Db db = new Db();
//		for (Map.Entry<String, DbWIFI> m : db.select("37.593059", "126.950089").entrySet()) {
//			System.out.printf("%s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s %s\n", m.getKey(),
//			m.getValue().getxSwifiMgrNo(), m.getValue().getxSwifiWrdofc(),
//			m.getValue().getxSwifiMaimNm(), m.getValue().getxSwifiAdres1(),
//			m.getValue().getxSwifiAdres2(), m.getValue().getxSwifiInstlFloor(),
//			m.getValue().getxSwifiInstlTy(), m.getValue().getxSwifiInstlMby(),
//			m.getValue().getxSwifiSvcSe(), m.getValue().getxSwifiCmcwr(),
//			m.getValue().getxSwifiCnstcYear(), m.getValue().getxSwifiInoutDoor(),
//			m.getValue().getxSwifiRemars3(),m.getValue().getLat(),
//			m.getValue().getLnt(), m.getValue().getWorkDttm());
//		}
//		
		
	}
	
	
    
}
