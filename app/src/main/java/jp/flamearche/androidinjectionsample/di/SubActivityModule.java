/*
 * Copyright 2017 Kazuki Kanda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.flamearche.androidinjectionsample.di;

import dagger.Module;
import dagger.Provides;
import jp.flamearche.androidinjectionsample.SubActivity;
import jp.flamearche.androidinjectionsample.viewModel.SubActivityViewModel;

@Module
class SubActivityModule {
    @Provides
    @PerActivity
    @UserName
    String provideUserName(SubActivity activity) {
        return activity.getIntent().getStringExtra(SubActivity.EXTRA_NAME_USER_NAME);
    }

    @Provides
    @PerActivity
    SubActivityViewModel provideSubActivityViewModel(@UserName String userName) {
        return new SubActivityViewModel(userName);
    }
}
