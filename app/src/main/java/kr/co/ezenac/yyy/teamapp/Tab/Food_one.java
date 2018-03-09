package kr.co.ezenac.yyy.teamapp.Tab;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import kr.co.ezenac.yyy.teamapp.R;
import lombok.NoArgsConstructor;

/**
 * Created by Administrator on 2018-02-09.
 */
@NoArgsConstructor
public class Food_one extends Fragment {

    ArrayList<Food_one_Item> food_one_itemArrayList;
    Food_one_Adapter food_one_adapter;
    GridView food_one_girdView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        RelativeLayout layout = (RelativeLayout) inflater.inflate(R.layout.food_one, container, false);

        //View view = inflater.inflate(R.layout.food_one, container, false);
        //view.findViewById(R.id.food_one_girdView);

        food_one_girdView = layout.findViewById(R.id.food_one_girdView);
        String url = "http://apis.data.go.kr/B553077/api/open/sdsc/storeListInDong?numOfRows=100&pageNo=%22%20+%20page%20+%22&divId=signguCd&key=11680&indsLclsCd=Q&indsMclsCd=Q01&type=json&ServiceKey=KVpVy2hviIkGCKrIB4fHC5tSWnpH0k25gEmHwvAv86YyFa3W3k7VOWTYyh38jbSs9gUogrqxLGzfGsEUjj8w%2Fg%3D%3D";
        NetworkTask networkTask = new NetworkTask();
        networkTask.execute(url);
        return layout;
    }

    public class NetworkTask extends AsyncTask<String, Integer, String> {

        String string, jsonString;

        @Override
        protected String doInBackground(String... strings) {
            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;
            try {
                URL url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                if (inputStream == null) {
                    return null;
                }
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
                bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer stringBuffer = new StringBuffer();
                while ((string = bufferedReader.readLine()) != null) {
                    stringBuffer.append(string);
                }
                jsonString = stringBuffer.toString();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            return jsonString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            food_one_itemArrayList = new ArrayList<>();
            Long totalCount;
            try {
                JSONObject jsonHeaderBody = new JSONObject(s);
                //Toast.makeText(getActivity(), s, Toast.LENGTH_LONG).show();
                JSONObject jsonBody = jsonHeaderBody.getJSONObject("body");
                JSONArray jsonItems = jsonBody.getJSONArray("items");
                //totalCount = (Long) jsonBody.get("totalCount");
                for (int i = 0; i < jsonItems.length(); i++) {
                    JSONObject item = jsonItems.getJSONObject(i);

                    String bizesId = (String) item.get("bizesId");
                    String bizesNm = (String) item.get("bizesNm");
                    String brchNm = (String) item.get("brchNm");
                    String indsLclsCd = (String) item.get("indsLclsCd");
                    String indsLclsNm = (String) item.get("indsLclsNm");
                    String indsMclsCd = (String) item.get("indsMclsCd");
                    String indsMclsNm = (String) item.get("indsMclsNm");
                    String indsSclsCd = (String) item.get("indsSclsCd");
                    String indsSclsNm = (String) item.get("indsSclsNm");
                    String ksicCd = (String) item.get("ksicCd");
                    String ksicNm = (String) item.get("ksicNm");
                    String ctprvnCd = (String) item.get("ctprvnCd");
                    String ctprvnNm = (String) item.get("ctprvnNm");
                    String signguCd = (String) item.get("signguCd");
                    String signguNm = (String) item.get("signguNm");
                    String adongCd = (String) item.get("adongCd");
                    String adongNm = (String) item.get("adongNm");
                    String ldongCd = (String) item.get("ldongCd");
                    String ldongNm = (String) item.get("ldongNm");
                    String lnoCd = (String) item.get("lnoCd");
                    String plotSctCd = (String) item.get("plotSctCd");
                    String plotSctNm = (String) item.get("plotSctNm");
                    Integer lnoMnno = (Integer) item.get("lnoMnno");
                    //String lnoSlno = (String) item.get("lnoSlno");
                    String lnoAdr = (String) item.get("lnoAdr");
                    String rdnmCd = (String) item.get("rdnmCd");
                    String rdnm = (String) item.get("rdnm");
                    Integer bldMnno = (Integer) item.get("bldMnno");
                    //String bldSlno = (String) item.get("bldSlno");
                    String bldMngNo = (String) item.get("bldMngNo");
                    String bldNm = (String) item.get("bldNm");
                    String rdnmAdr = (String) item.get("rdnmAdr");
                    String oldZipcd = (String) item.get("oldZipcd");
                    String newZipcd = (String) item.get("newZipcd");
                    String dongNo = (String) item.get("dongNo");
                    String flrNo = (String) item.get("flrNo");
                    String hoNo = (String) item.get("hoNo");
                    Double lon = (Double) item.get("lon");
                    Double lat = (Double) item.get("lat");

                    Food_one_Item food_one_item = new Food_one_Item();

                    food_one_item.setBizesId(bizesId);
                    food_one_item.setBizesNm(bizesNm);
                    food_one_item.setBrchNm(brchNm);
                    food_one_item.setIndsLclsCd(indsLclsCd);
                    food_one_item.setIndsLclsNm(indsLclsNm);
                    food_one_item.setIndsMclsCd(indsMclsCd);
                    food_one_item.setIndsMclsNm(indsMclsNm);
                    food_one_item.setIndsSclsCd(indsSclsCd);
                    food_one_item.setIndsSclsNm(indsSclsNm);
                    food_one_item.setKsicCd(ksicCd);
                    food_one_item.setKsicNm(ksicNm);
                    food_one_item.setCtprvnCd(ctprvnCd);
                    food_one_item.setCtprvnNm(ctprvnNm);
                    food_one_item.setSignguCd(signguCd);
                    food_one_item.setSignguNm(signguNm);
                    food_one_item.setAdongCd(adongCd);
                    food_one_item.setAdongNm(adongNm);
                    food_one_item.setLdongCd(ldongCd);
                    food_one_item.setLdongNm(ldongNm);
                    food_one_item.setLnoCd(lnoCd);
                    food_one_item.setPlotSctCd(plotSctCd);
                    food_one_item.setPlotSctNm(plotSctNm);
                    food_one_item.setLnoMnno(lnoMnno);
                    //food_one_item.setLnoSlno(lnoSlno);
                    food_one_item.setLnoAdr(lnoAdr);
                    food_one_item.setRdnmCd(rdnmCd);
                    food_one_item.setRdnm(rdnm);
                    food_one_item.setBldMnno(bldMnno);
                    //food_one_item.setBldSlno(bldSlno);
                    food_one_item.setBldMngNo(bldMngNo);
                    food_one_item.setBldNm(bldNm);
                    food_one_item.setRdnmAdr(rdnmAdr);
                    food_one_item.setOldZipcd(oldZipcd);
                    food_one_item.setNewZipcd(newZipcd);
                    food_one_item.setDongNo(dongNo);
                    food_one_item.setFlrNo(flrNo);
                    food_one_item.setHoNo(hoNo);
                    food_one_item.setLon(lon);
                    food_one_item.setLat(lat);

                    food_one_itemArrayList.add(food_one_item);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                food_one_adapter = new Food_one_Adapter(getActivity(), food_one_itemArrayList);
                food_one_girdView.setAdapter(food_one_adapter);
                food_one_adapter.notifyDataSetChanged();
            }
        }
    }
}
