package com.recycledemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecycleActivity extends AppCompatActivity {

    RecyclerView recycle;

    String dataArray = "{\"data\":[{\"type\":0,\"name\":\"Google\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"type\":0,\"name\":\"Yahoo\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"type\":1,\"indata\":[{\"name\":\"Android\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"name\":\"Google Maps\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"name\":\"Google Play\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"}]},{\"type\":0,\"name\":\"Twitter\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"type\":0,\"name\":\"Facebook\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"type\":1,\"indata\":[{\"name\":\"Android\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"name\":\"Google Maps\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"name\":\"Google Play\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"}]},{\"type\":0,\"name\":\"Facebook\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"type\":0,\"name\":\"Facebook\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"},{\"type\":0,\"name\":\"Facebook\",\"desc\":\"Lorazepam belongs to a group of drugs called benzodiazepines. It affects chemicals in the brain that may be unbalanced in people with anxiety.\"}]}";
    JSONObject jsonObject;
    ArrayList<M_Main> m_mainArrayList;
    ArrayList<M_child> m_childArrayList;
    AdapterRecycle adapterRecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        m_mainArrayList = new ArrayList<>();
        m_childArrayList = new ArrayList<>();

        try {
            jsonObject = new JSONObject(dataArray);

            JSONArray jsonArray = jsonObject.optJSONArray("data");
            int lengthJsonArr = jsonArray.length();
            M_Main mMain;

            for (int i = 0; i < lengthJsonArr; i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                mMain = new M_Main();
                int typeId = jsonObject1.getInt("type");
                mMain.setType(typeId);
                if (typeId == 0) {
                    String name = jsonObject1.getString("name");
                    String desc = jsonObject1.getString("desc");
                    mMain.setName(name);
                    mMain.setDesc(desc);
                } else if (typeId == 1) {
                    JSONArray jsonArray2 = jsonObject1.optJSONArray("indata");
                    int lengthJsonArr1 = jsonArray2.length();

                    m_childArrayList.clear();
                    for (int j = 0; j < lengthJsonArr1; j++) {
                        JSONObject jsonObject2 = jsonArray2.getJSONObject(j);
                        String childname = jsonObject2.getString("name");
                        String childdesc = jsonObject2.getString("desc");
                        M_child m_child = new M_child();
                        m_child.setChildname(childname);
                        m_child.setChilddesc(childdesc);
                        m_childArrayList.add(m_child);
                        mMain.setmChildren(m_childArrayList);
                    }
                }
                m_mainArrayList.add(mMain);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        recycle = (RecyclerView) findViewById(R.id.recycle);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RecycleActivity.this);
        recycle.setLayoutManager(layoutManager);


        adapterRecycle = new AdapterRecycle(this,m_mainArrayList);
        recycle.setAdapter(adapterRecycle);
    }
}
