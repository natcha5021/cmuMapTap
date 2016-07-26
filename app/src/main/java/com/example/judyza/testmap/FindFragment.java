package com.example.judyza.testmap;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FindFragment extends Fragment {
    Context mContext;
    //// Text topic
    TextView coderoomT;
    TextView buildinameT;
    TextView floorT;
    TextView noteT;
    Button searchButton;
    ///// display
    EditText userinput;
    TextView coderoomText;
    TextView buildinameText;
    TextView noteText;
    TextView floorText;
    MyDBHandler dbHandler;

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
       mContext=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.find_fragment, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        // During startup, check if there are arguments passed to the fragment.
        // onStart is a good place to do this because the layout has already been
        // applied to the fragment at this point so we can safely call the method
        // below that sets the article text.
//                                Bundle args = getArguments();
//                                if (args != null) {
//                                    // Set article based on argument passed in
//                                    updateArticleView(args.getInt(ARG_POSITION));
//                                } else if (mCurrentPosition != -1) {
//                                    // Set article based on saved instance state defined during onCreateView
//                                    updateArticleView();
//                                }

        searchButton = (Button) getActivity().findViewById(R.id.SearchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null)
//                        .show();

                String inputSearch = userinput.getText().toString();
                String displayRoomCode =  dbHandler.getCodeNamebyCode(inputSearch);
                String displayBuildingName =  dbHandler.getBuildingnamebyCode(inputSearch);
                String displaynote =  dbHandler.getNotebyCode(inputSearch);
                String displayFloor = getFloorbyRoomcode(inputSearch);
                coderoomText.setText(displayRoomCode);
                buildinameText.setText(displayBuildingName);
                floorText.setText(displayFloor);
                noteText.setText(displaynote );
                userinput.setText("");;
                //////////// topic
                coderoomT.setText("Code Room :");
                buildinameT.setText("Building Name :");
                floorT.setText("Floor :");
                noteT.setText("Note : ");
            }
        });

        userinput = (EditText) getActivity().findViewById(R.id.editText);
        ///// text topic
        coderoomT = (TextView) getActivity().findViewById(R.id.roomcodeView);
        buildinameT = (TextView) getActivity().findViewById(R.id.builingnmaeView);
        floorT = (TextView) getActivity().findViewById(R.id.floorView);
        noteT = (TextView) getActivity().findViewById(R.id.noteView);
        ////// display
        coderoomText = (TextView) getActivity().findViewById(R.id.roodcode_actor);
        buildinameText = (TextView) getActivity().findViewById(R.id.buildingname_actor);
        floorText = (TextView) getActivity().findViewById(R.id.floor_actor);
        noteText = (TextView) getActivity().findViewById(R.id.note_actor);
        dbHandler = new MyDBHandler(getActivity().getApplicationContext(),null,null,1);
        hideResult();
        Mock();

    }

    public void updateArticleView() {

//      //  setContentView(R.layout.activity_main);
//        userinput = (EditText) getActivity().findViewById(R.id.editText);
//        ///// text topic
//        coderoomT = (TextView) getActivity().findViewById(R.id.roomcodeView);
//        buildinameT = (TextView) getActivity().findViewById(R.id.builingnmaeView);
//        floorT = (TextView) getActivity().findViewById(R.id.floorView);
//        noteT = (TextView) getActivity().findViewById(R.id.noteView);
//        ////// display
//        coderoomText = (TextView) getActivity().findViewById(R.id.roodcode_actor);
//        buildinameText = (TextView) getActivity().findViewById(R.id.buildingname_actor);
//        floorText = (TextView) getActivity().findViewById(R.id.floor_actor);
//        noteText = (TextView) getActivity().findViewById(R.id.note_actor);
//        dbHandler = new MyDBHandler(this,null,null,1);
//        hideResult();
//        Mock();

    }

//        public void SearchButtonClicked(View view){
//        String inputSearch = userinput.getText().toString();
//            String displayRoomCode =  dbHandler.getCodeNamebyCode(inputSearch);
//            String displayBuildingName =  dbHandler.getBuildingnamebyCode(inputSearch);
//            String displaynote =  dbHandler.getNotebyCode(inputSearch);
//            String displayFloor = getFloorbyRoomcode(inputSearch);
//            coderoomText.setText(displayRoomCode);
//            buildinameText.setText(displayBuildingName);
//            floorText.setText(displayFloor);
//            noteText.setText(displaynote );
//            userinput.setText("");;
//            //////////// topic
//            coderoomT.setText("Code Room :");
//            buildinameT.setText("Building Name :");
//            floorT.setText("Floor :");
//            noteT.setText("Note : ");
//        }

    public String getFloorbyRoomcode (String roomcode){
        String test = roomcode;
        String[] t = test.split("(?!^)");
        int count = t.length;

        int index = (count-3);

        return t[index];
    }
    public void Mock(){
        AddproductMock("เหลือง","วิจิตำ","WJ210");
        AddproductMock("แดง","เรียนร่วม5","RR5210");

    }

    public void AddproductMock(String note, String buildingname, String roomcode){
        IRoom croom = new IRoom(note, buildingname, roomcode);
        dbHandler.addroom(croom);

    }

    public void hideResult(){
        coderoomT.setText("");
        buildinameT.setText("");
        floorT.setText("");
        noteT.setText("");
        ////// display
        coderoomText.setText("");
        buildinameText.setText("");
        floorText.setText("");
        noteText.setText("");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Save the current article selection in case we need to recreate the fragment
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
//    public void printDatabase(){
//        String dbString = dbHandler.databaseToString();
//        noteText.setText(dbString);
//        userinput.setText("");
//    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.find_fragment);
//        userinput = (EditText) findViewById(R.id.editText);
//        ///// text topic
//        coderoomT = (TextView)findViewById(R.id.roomcodeView);
//        buildinameT = (TextView)findViewById(R.id.builingnmaeView);
//        floorT = (TextView) findViewById(R.id.floorView);
//        noteT = (TextView) findViewById(R.id.noteView);
//        ////// display
//        coderoomText = (TextView) findViewById(R.id.roodcode_actor);
//        buildinameText = (TextView) findViewById(R.id.buildingname_actor);
//        floorText = (TextView) findViewById(R.id.floor_actor);
//        noteText = (TextView) findViewById(R.id.note_actor);
//        dbHandler = new MyDBHandler(this,null,null,1);
//        hideResult();
//        Mock();
//
////        printDatabase();
//    }
}
