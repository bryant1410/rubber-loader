package com.greenfrvr.rubberloader.sample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import com.greenfrvr.rubberloader.sample.R;
import com.greenfrvr.rubberloader.sample.utils.IntentFactory;

import butterknife.Bind;

/**
 * Created by greenfrvr
 */
public class ContactsFragment extends BaseFragment {

    protected @Bind(R.id.contact) TextView contactTextView;
    protected @Bind(R.id.sources) TextView sourcesTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contacts, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        contactTextView.setMovementMethod(LinkMovementMethod.getInstance());
        sourcesTextView.setMovementMethod(LinkMovementMethod.getInstance());

        contactTextView.setText(getContactText());
        sourcesTextView.setText(getSourcesText());
    }

    private CharSequence getSourcesText() {
        SpannableString spannable = new SpannableString(getString(R.string.sources));
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                IntentFactory.explore(getActivity(), getString(R.string.github));
            }
        }, spannable.toString().length() - 6, spannable.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }

    private CharSequence getContactText() {
        SpannableString spannable = new SpannableString(getString(R.string.contact));
        spannable.setSpan(new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                IntentFactory.email(getActivity(), getString(R.string.email));
            }
        }, 8, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannable;
    }
}
