package com.syafikha.assolah;
import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.app.TimePickerDialog.OnTimeSetListener;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import static android.R.attr.id;

public class notification extends Activity {

    TimePicker myTimePicker;
    Button buttonstartSetDialog;
    Button btn1,btn2,btn3,btn4;

    private Button button;

    TimePickerDialog timePickerDialog;
    final Context context= this;
    final static int RQS_1 = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);



        buttonstartSetDialog = (Button)findViewById(R.id.btnNoti);
        buttonstartSetDialog.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                openTimePickerDialog(false);
            }});

        btn1 = (Button)findViewById(R.id.btnNoti1);
        btn1.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                openTimePickerDialog(false);
            }});

        btn2 = (Button)findViewById(R.id.btnNoti2);
        btn2.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {

                openTimePickerDialog(false);

            }});

        btn3 = (Button)findViewById(R.id.btnNoti3);
        btn3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                openTimePickerDialog(false);
            }});

        btn4 = (Button)findViewById(R.id.btnNoti4);
        btn4.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                openTimePickerDialog(false);
            }});

        //Create Alert Dialog to close app
        button=(Button) findViewById(R.id.btnExit1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy=new Intent(notification.this,MainActivity.class);
                startActivity(toy);
            }
        });
    }

    //create method to open time picker
    private void openTimePickerDialog(boolean is24r){
        Calendar calendar = Calendar.getInstance();
        timePickerDialog = new TimePickerDialog(
                notification.this,
                onTimeSetListener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                is24r);
        timePickerDialog.setTitle("Set Notification Time");
        timePickerDialog.show();
    }

    OnTimeSetListener onTimeSetListener = new OnTimeSetListener(){

        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

            Calendar calNow = Calendar.getInstance();
            Calendar calSet = (Calendar) calNow.clone();

            calSet.set(Calendar.HOUR_OF_DAY, hourOfDay);
            calSet.set(Calendar.MINUTE, minute);
            calSet.set(Calendar.SECOND, 0);
            calSet.set(Calendar.MILLISECOND, 0);

            if (calSet.compareTo(calNow) <= 0) {
                //Today Set time passed, count to tomorrow
                calSet.add(Calendar.DATE, 1);
            }
            setAlarm(calSet);

        }};


    private void setAlarm(Calendar targetCal){

        // textAlarmPrompt.setText("Prayer time is at " + targetCal.getTime());

        Toast.makeText(this, "Notification set", Toast.LENGTH_LONG).show();

        //Passing custom value to AlarmNotificationService using pending Intent
        Intent intent = new Intent(getBaseContext(), AlarmReceive.class);
        //intent.putExtra("msg", textAlarmPrompt.getText().toString());
        intent.putExtra("msg","Let choose the nearest mosques around you");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), id, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, targetCal.getTimeInMillis(), pendingIntent);

    }



}
