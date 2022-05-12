package com.example.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    ArrayList<MyListData> myListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myListData = new ArrayList<>();
        myListData.add(new MyListData("Email", android.R.drawable.ic_dialog_email));
        myListData.add(new MyListData("Info", android.R.drawable.ic_dialog_info));
        myListData.add(new MyListData("Delete", android.R.drawable.ic_delete));
        myListData.add(new MyListData("Dialer", android.R.drawable.ic_dialog_dialer));
        myListData.add(new MyListData("Alert", android.R.drawable.ic_dialog_alert));
        myListData.add(new MyListData("Map", android.R.drawable.ic_dialog_map));

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new MyListAdapter(myListData);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        registerForContextMenu(recyclerView);
        registerForContextMenu(recyclerView);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
//                        Toast.makeText(MainMenu.this, myListData[position].getDescription(), Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext() , DetailActivity.class);
                        // post data
                        startActivity(intent);
                        //pindah ke halaman detail
                    }
                })
        );
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int position = ((MyListAdapter)recyclerView.getAdapter()).getPosition();
        switch (item.getItemId()) {
            case R.id.call:
                Toast.makeText(this, "You select Copy for: "+myListData.get(position).getDescription(), Toast.LENGTH_SHORT).show();

                return true;
            case R.id.sms:
                Toast.makeText(this, "You select Paste for: "+myListData.get(position).getDescription(), Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onContextItemSelected(item);
    }


}
    }
}