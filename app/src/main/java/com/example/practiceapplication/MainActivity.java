package com.example.practiceapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private EditText edtTxtName, edtTxtEmail, edtTxtPassword, edtTxtPassRepeat;
    private Button btnPickImage, btnRegister;
    private TextView txtWarnName, txtWarnEmail, txtWarnPassword, txtWarnPassRepeat;
    private Spinner countriesSpinner;
    private RadioGroup rgGender;
    private CheckBox agreementCheck;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnPickImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Yet to talk about", Toast.LENGTH_SHORT).show();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegister();
            }
        });

    }

    private void initRegister() {
        Log.d(TAG,"validatedDate: started");

        if (validateDate()) {
            if (agreementCheck.isChecked()) {
                showSnackBar();
            } else {
                Toast.makeText(this, "You need to agree to the licence agreement", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void showSnackBar() {
        Log.d(TAG,"showSnackBar: Started");
        txtWarnName.setVisibility(View.GONE);
        txtWarnEmail.setVisibility(View.GONE);
        txtWarnPassword.setVisibility(View.GONE);
        txtWarnPassRepeat.setVisibility(View.GONE);

        String name = edtTxtName.getText().toString();
        String email = edtTxtEmail.getText().toString();
        String password = edtTxtPassword.getText().toString();
        String country = countriesSpinner.getSelectedItem().toString();
        String gender = "";

        switch (rgGender.getCheckedRadioButtonId()) {
            case R.id.rbMale:
                gender = "Male";
                break;

            case R.id.rbFemale:
                gender = "Female";
                break;

            case R.id.rbOther:
                gender = "Other";
                break;
            default:
                gender = "Unknown";
                break;
        }

        String snackText = "Name: " + name + "\n" +
                "Name: " + email + "\n" +
                "Name: " + gender + "\n" +
                "Name: " + country;

        Snackbar.make(parent,snackText,Snackbar.LENGTH_INDEFINITE)
                .setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edtTxtName.setText("");
                        edtTxtEmail.setText("");
                        edtTxtPassword.setText("");
                        edtTxtPassRepeat.setText("");
                    }
                }).show();
    }

    private boolean validateDate() {
        if (checkEmpty(txtWarnName,"Name") || checkEmpty(txtWarnEmail,"Email") || checkEmpty(txtWarnPassword,"Password") || checkEmpty(txtWarnPassRepeat,"RePassword")) {
            return false;
        }
        if (!edtTxtPassword.getText().toString().equals(edtTxtPassRepeat.getText().toString())){
            txtWarnPassRepeat.setVisibility(View.VISIBLE);
            txtWarnPassRepeat.setText("Password doesn't match");
            return false;
        }
        return true;
    }

    private boolean checkEmpty(TextView value, String name) {
        String label = "Enter your " + name;
        if (value.getText().toString().equals("")) {
            value.setVisibility(View.VISIBLE);
            value.setText(label);
            return true;
        }
        return false;
    }

    private void initViews() {
        Log.d("initViews","Start: ");
        edtTxtName = findViewById(R.id.edtTxtName);
        edtTxtEmail = findViewById(R.id.edtTxtEmail);
        edtTxtPassword = findViewById(R.id.edtTxtPassword);
        edtTxtPassRepeat = findViewById(R.id.edtTxtPassRepeat);

        btnPickImage = findViewById(R.id.btnPickImage);
        btnRegister = findViewById(R.id.btnRegister);

        txtWarnName = findViewById(R.id.txtWarnName);
        txtWarnEmail = findViewById(R.id.txtWarnEmail);
        txtWarnPassword = findViewById(R.id.txtWarnPassword);
        txtWarnPassRepeat = findViewById(R.id.txtWarnPassRepeat);

        countriesSpinner = findViewById(R.id.spinnerCountry);
        rgGender = findViewById(R.id.rgGender);
        agreementCheck = findViewById(R.id.agreementCheck);
        parent = findViewById(R.id.parent);
    }
}

//    private MaterialCardView cardView;
//    private RecyclerView contactsView;
//    private ConstraintLayout parent;
//    private Button btnShowSnackbar;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        parent = findViewById(R.id.parent);
//        btnShowSnackbar = findViewById(R.id.button);
//
//        btnShowSnackbar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                showSnackbar();
//            }
//        });
//
//    }
//
//    private void showSnackbar() {
//        Snackbar.make(parent,"This is a Snackbar", Snackbar.LENGTH_INDEFINITE)
//                .setAction("Retry", new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        Toast.makeText(MainActivity.this, "Retry clicked", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .setActionTextColor(getResources().getColor(R.color.blue))
//                .setTextColor(Color.YELLOW)
//                .show();
//    }
//}

//        contactsView = findViewById(R.id.contactsRecView);
//
//        ArrayList<Contact> contacts = new ArrayList<>();
//        contacts.add(new Contact("Majar hate","major@gmail.com","https://cdn.pixabay.com/photo/2020/06/26/17/17/tigre-5343426_960_720.jpg"));
//        contacts.add(new Contact("Cliian Horse","horse@gmail.com","https://www.nationalgeographic.com/content/dam/magazine/rights-exempt/2019/10/extinction/south-china-tiger.adapt.1900.1.jpg"));
//        contacts.add(new Contact("ronan Tiger","tiger@gmail.com","https://www.cambridgema.gov/-/media/Images/sharedphotos/departmentphotos/animal.jpg?mw=1920"));
//        contacts.add(new Contact("Lion Cristian","lion@gmail.com","https://www.trafalgar.com/real-word/wp-content/uploads/sites/3/2019/10/giant-panda-750x400.jpg"));
//        contacts.add(new Contact("Lion holland","lion@gmail.com","https://www.cdc.gov/coronavirus/2019-ncov/images/daily-life-coping/tiger-medium.JPG"));
//
//        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
//        adapter.setContacts(contacts);
//
//        contactsView.setAdapter(adapter);
//        contactsView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
//        contactsView.setLayoutManager(new GridLayoutManager(this, 2));

//        cardView = findViewById(R.id.cardView);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Card Clicked", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

//    private ListView citiesList;
//    private Spinner studentsSpinner;
//    private TextView textHello;
//    private FloatingActionButton fab;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "Click to Float broad", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

//        textHello = findViewById(R.id.textHello);
//        textHello.setText(getString(R.string.hello));
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.main_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.setting_menu:
//                Toast.makeText(this, "Settings Selected", Toast.LENGTH_SHORT).show();
//                return true;
//            case R.id.alarm_menu:
//                Toast.makeText(this, "Alarm Selected", Toast.LENGTH_SHORT).show();
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
//}

//        citiesList = findViewById(R.id.citiesList);
//        studentsSpinner = findViewById(R.id.studentsSpinner);

//        ArrayList<String> students = new ArrayList<String>();
//        students.add("Meisam");
//        students.add("Brad");
//        students.add("Sarah");
//        students.add("Madeline");
//        students.add("Tom");
//
//        ArrayAdapter<String> studentsAdapter = new ArrayAdapter<String>(
//                this,
//                android.R.layout.simple_spinner_dropdown_item,
//                students
//        );
//
//        studentsSpinner.setAdapter(studentsAdapter);

//        studentsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "Selected: " + studentsSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });
//
//        ArrayList<String> cities = new ArrayList<>();
//        cities.add("Zurich");
//        cities.add("New York");
//        cities.add("Berlin");
//        cities.add("Moscow");
//        cities.add("Madrid");
//
//        ArrayAdapter<String> citiesAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                cities
//        );
//
//        citiesList.setAdapter(citiesAdapter);
//        citiesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(MainActivity.this, "Selected: " + cities.get(i), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//}

//    private CheckBox checkBoxHarry, checkBoxMattrix, chekCheckBoxJoker;
//    private RadioGroup rgMarriedStatus;
//    private RadioButton rbMarried, rbSingle, rbRel;
//    private ProgressBar progressBar;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        checkBoxHarry = findViewById(R.id.checkboxHarry);
//        checkBoxMattrix = findViewById(R.id.checkboxMattrix);
//        chekCheckBoxJoker = findViewById(R.id.checkboxJoker);
//
//        if (checkBoxHarry.isChecked()) {
//            Toast.makeText(MainActivity.this, "You have watched Harry check box, yet", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
//        }
//
//        checkBoxHarry.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                if (b) {
//                    Toast.makeText(MainActivity.this, "You have watched Harry check box, yet", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(MainActivity.this, "You need to watch Harry Potter", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//
//        // Married Status
//        rgMarriedStatus = findViewById(R.id.rgMarriedStatus);
//        // progress Bar:
//        progressBar = findViewById(R.id.progressBar);
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i =0; i<10;i++) {
//                    progressBar.incrementProgressBy(10);
//                    SystemClock.sleep(500);
//                }
//            }
//        });
//        thread.start();
//
//        int checkedButton = rgMarriedStatus.getCheckedRadioButtonId();
//        switch (checkedButton) {
//            case R.id.rbMarried:
//                Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.rbSingle:
//                Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
//                break;
//
//            case R.id.rbRel:
//                Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
//                break;
//        }
//
//        rgMarriedStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//                switch (i) {
//                    case R.id.rbMarried:
//                        Toast.makeText(MainActivity.this, "Married", Toast.LENGTH_SHORT).show();
//                        break;
//
//                    case R.id.rbSingle:
//                        Toast.makeText(MainActivity.this, "Single", Toast.LENGTH_SHORT).show();
////                        progressBar.setVisibility(View.VISIBLE);
//                        break;
//                    case R.id.rbRel:
//                        Toast.makeText(MainActivity.this, "In a Relationship", Toast.LENGTH_SHORT).show();
////                        progressBar.setVisibility(View.GONE);
//                        break;
//                    default:
//                        break;
//                }
//            }
//        });
//
//
//    }
//}