<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEDUCATIONEditViewBase from './pimeducationedit-view-base.vue';

import view_form from '@widgets/pim-education/main-form/main-form.vue';

/**
 * 教育信息编辑视图
 *
 * @export
 * @class PIMEDUCATIONEditView
 * @extends {PIMEDUCATIONEditViewBase}
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
export default class PIMEDUCATIONEditView extends PIMEDUCATIONEditViewBase { }
</script>