<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TestResultEditViewBase from './test-result-edit-view-base.vue';

import view_form from '@widgets/pcm-test-result/main-form/main-form.vue';

/**
 * 测评结果摘要信息
 *
 * @export
 * @class TestResultEditView
 * @extends {TestResultEditViewBase}
 */
@Component({
    components: {
        view_form, 
    },
    beforeRouteEnter: (to: any, from: any, next: any) => {
        next((vm: any) => {
            vm.$store.commit('addCurPageViewtag', { fullPath: to.fullPath, viewtag: vm.viewtag });
        });
    },
})
export default class TestResultEditView extends TestResultEditViewBase { }
</script>