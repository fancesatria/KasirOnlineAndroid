package com.example.authapp.Database.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.authapp.Model.ModelBarang;

import java.util.List;

@Dao
public interface BarangDao {
    @Insert(onConflict  = OnConflictStrategy.REPLACE)
    void insertAll(List<ModelBarang> barangs);

    @Insert(onConflict  = OnConflictStrategy.REPLACE)
    void insert(ModelBarang barang);

    @Query("select * from tblbarang where barang like :keyword or idbarang like :keyword")
    LiveData<List<ModelBarang>> getBarang(String keyword);

    @Delete
    void delete(ModelBarang barang);

    @Query("DELETE FROM tblbarang")
    void deleteAll();
}