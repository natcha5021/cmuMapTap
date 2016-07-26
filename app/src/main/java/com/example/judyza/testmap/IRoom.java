package com.example.judyza.testmap;

/**
 * Created by oo on 24/7/2559.
 */
public class IRoom {
    private int _id;
    private String _roomcode;
    private String _buildingname;
    private String _note;

    public IRoom(){}

    public IRoom(String _note, String _buildingname, String _roomcode) {
        this._note = _note;
        this._buildingname = _buildingname;
        this._roomcode = _roomcode;
    }

    public String get_note() {
        return _note;
    }

    public void set_note(String _note) {
        this._note = _note;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public void set_roomcode(String _roomcode) {
        this._roomcode = _roomcode;
    }

    public void set_buildingname(String _buildingname) {
        this._buildingname = _buildingname;
    }


    public int get_id() {
        return _id;
    }

    public String get_roomcode() {
        return _roomcode;
    }

    public String get_buildingname() {
        return _buildingname;
    }

}



