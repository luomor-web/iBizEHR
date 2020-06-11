<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SALPERSONSTDDETAILEditViewBase from './salpersonstddetailedit-view-base.vue';

import view_form from '@widgets/salpersonstddetail/main-form/main-form.vue';

/**
 * 员工薪酬标准明细编辑视图
 *
 * @export
 * @class SALPERSONSTDDETAILEditView
 * @extends {SALPERSONSTDDETAILEditViewBase}
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
export default class SALPERSONSTDDETAILEditView extends SALPERSONSTDDETAILEditViewBase { }
</script>