package com.example.btb2_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Menu menu;
    ImageButton mButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(MainActivity.this,menu_activity.class);

        mButton =    (ImageButton) findViewById(R.id.button_popup);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, mButton);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
                popup.setOnMenuItemClickListener(    new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getItemId() == R.id.forward)
                            {
                                intent.putExtra("menu_activity","Forward Completed!!");
                                startActivity(intent);
                            }
                            else
                            {
                                intent.putExtra("menu_activity","Reply Completed!!");
                                startActivity(intent);
                            }
                                return false;
                    }
                });
                popup.show();
            }
        });

        TextView textViewMenu = findViewById(R.id.textviewmenu);
        registerForContextMenu(textViewMenu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu ) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,menu_activity.class);
        if(item.getItemId() == R.id.option_settings)
            {
                intent.putExtra("menu_activity","Opening setting!!");
                startActivity(intent);
            }
            else
            {
                intent.putExtra("menu_activity","Opening favorites!!");
                startActivity(intent);
            }
                return super.onOptionsItemSelected(item);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Chose your option!");
        if (v.getId() == R.id.textviewmenu) {
            getMenuInflater().inflate(R.menu.context_menu, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Intent intent = new Intent(MainActivity.this,menu_activity.class);
        if(item.getItemId() == R.id.context_edit) {
                Toast.makeText(this, "option 1 selected", Toast.LENGTH_SHORT).show();
                intent.putExtra("menu_activity", "Editing!!");
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "option 1 selected", Toast.LENGTH_SHORT).show();
                intent.putExtra("menu_activity", "Sharing!!");
                startActivity(intent);
            }
            return super.onContextItemSelected(item);
    }
}