<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import QUESTIONSYH_CheckEditViewBase from './questionsyh-check-edit-view-base.vue';

import view_form from '@widgets/pim-questions/yh-check-form/yh-check-form.vue';

/**
 * 用户查看表单
 *
 * @export
 * @class QUESTIONSYH_CheckEditView
 * @extends {QUESTIONSYH_CheckEditViewBase}
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
export default class QUESTIONSYH_CheckEditView extends QUESTIONSYH_CheckEditViewBase { }
</script>