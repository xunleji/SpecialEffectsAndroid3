package com.example.specialeffectsandroid3.fileexplore.library;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.specialeffectsandroid3.R;

public class DirectoryFragment extends Fragment {

	interface FileClickListener {
		void onFileClicked(File clickedFile);
	}

	private static final String ARG_FILE_PATH = "arg_file_path";

	private View mEmptyView;
	private String mPath;
	private EmptyRecyclerView mDirectoryRecyclerView;
	private DirectoryAdapter mDirectoryAdapter;
	private FileClickListener mFileClickListener;

	public static DirectoryFragment getInstance(String path) {
		DirectoryFragment instance = new DirectoryFragment();

		Bundle args = new Bundle();
		args.putString(ARG_FILE_PATH, path);
		instance.setArguments(args);
		return instance;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mFileClickListener = (FileClickListener) activity;
	}

	@Override
	public void onDetach() {
		super.onDetach();
		mFileClickListener = null;
	}

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_directory, container,
				false);
		mDirectoryRecyclerView = (EmptyRecyclerView) view
				.findViewById(R.id.directory_recycler_view);
		mEmptyView = view.findViewById(R.id.directory_empty_view);
		return view;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initArgs();
		initFilesList();
	}

	private void initFilesList() {
		mDirectoryAdapter = new DirectoryAdapter(getActivity(),
				FileUtils.getFileListByDirPath(mPath));

		mDirectoryAdapter
				.setOnItemClickListener(new DirectoryAdapter.OnItemClickListener() {
					@Override
					public void onItemClick(View view, int position) {
						if (mFileClickListener != null) {
							mFileClickListener.onFileClicked(mDirectoryAdapter
									.getModel(position));
						}
					}
				});

		mDirectoryRecyclerView.setLayoutManager(new LinearLayoutManager(
				getActivity()));
		mDirectoryRecyclerView.setAdapter(mDirectoryAdapter);
		mDirectoryRecyclerView.setEmptyView(mEmptyView);
	}

	private void initArgs() {
		if (getArguments().getString(ARG_FILE_PATH) != null) {
			mPath = getArguments().getString(ARG_FILE_PATH);
		}
	}
}
