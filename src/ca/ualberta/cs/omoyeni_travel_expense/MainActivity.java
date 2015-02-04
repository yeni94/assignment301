/*
 *TravelExpense: Keeps a record of expenses for reimbursement
 *
 *Copyright {C} 2015 Omoyeni Adeyemo
 This program is free software: you can redistribute it and/or modify
 it under the terms of the GNU General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package ca.ualberta.cs.omoyeni_travel_expense;

import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.ArrayAdapter;


public class MainActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText claimName;
	//private ListView listOfClaims;
	//private ListView listOfExpenses;
	private ArrayList<String> claims;
	//private ArrayList<Expense> expenses;
	private ArrayAdapter<String> adapter;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listOfClaims = (ListView) findViewById(R.id.listOfClaims);
        Collection<Claim> claim = ClaimsListController.getClaimsList().getClaims();
        final ArrayList<Claim> list = new ArrayList<Claim>();
        ArrayAdapter<Claim> claimAdapter = new ArrayAdapter<Claim>(this, android.R.layout.simple_list_item_1, list);
        listOfClaims.setAdapter(claimAdapter);
        
        ClaimsListController.getClaimsList().addListener(new Listener(){

			@Override
			public void update() {
				list.clear();
				Collection<Claim> claim = ClaimsListController.getClaimsList().getClaims();
				list.addAll(claim);
				
			}
        	
        });
        
       /* claimName = (EditText) findViewById(R.id.claimNameText);
        Button newClaimButton = (Button) findViewById(R.id.addNewClaimButton);
        listOfClaims = (ListView) findViewById(R.id.listOfClaims);
        
        newClaimButton.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				setResult(RESULT_OK);
				String name = claimName.getText().toString();
				//Calendar currentDate = Calendar.getInstance();
				//saveInFile(name, new java.util.Date());
				claims.add(name);
				adapter.notifyDataSetChanged();
				
			}
		});
        */
       // populateListView();
    }
  /*  
    @Override
	protected void onStart() {
		
		super.onStart();
		//claims = loadFromFile();
		if (claims == null) {
			claims = new ArrayList<String>();
		}
		adapter = new ArrayAdapter<String>(this,
				R.layout.list_of_claims, claims);
		listOfClaims.setAdapter(adapter);
	}

	private ArrayList<String> loadFromFile() { //
		Gson gson = new Gson();
		ArrayList<String> claims = new ArrayList<String>();
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader in = new InputStreamReader(fis);
			//Taken from http://google-gson.googlecode.com/svn/trunk/son/docs/java
			Type typeOfT = new TypeToken<ArrayList<String>>(){}.getType();
			claims = gson.fromJson(in, typeOfT);
			fis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return claims; //changed Jan 20
	}
*/

    /*private void populateListView() {
		
    	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.list_of_claims,items);
		
	}
    
    


	protected void saveInFile(String name, java.util.Date date) {
		Gson gson = new Gson();
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			gson.toJson(claims, osw);
			osw.flush();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
*/

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    public void newClaim(View v){
    	Toast.makeText(this, "New Claim", Toast.LENGTH_SHORT).show();
    	ClaimsList cl = new ClaimsList();
    	EditText name = (EditText) findViewById(R.id.claimNameText);
    	cl.addClaim(new Claim(name.getText().toString()));
    	
    }
    
    public void editClaim(MenuItem menu){
    	Toast.makeText(this, "Edit Claim", Toast.LENGTH_SHORT).show();
    	/*Intent intent = new Intent(MainActivity.this, ExpenseActivity.class);
    	startActivity(intent);*/
    }
    
    public void deleteClaim(MenuItem menu){
    	Toast.makeText(this, "Claim Deleted", Toast.LENGTH_SHORT).show();
    }
    
    public void emailClaim(MenuItem menu){
    	Toast.makeText(this, "Claim Sent", Toast.LENGTH_SHORT).show();
    }
}
