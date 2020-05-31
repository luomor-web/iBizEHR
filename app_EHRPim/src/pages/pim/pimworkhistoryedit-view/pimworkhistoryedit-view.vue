<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMWORKHISTORYEditViewBase from './pimworkhistoryedit-view-base.vue';

import view_form from '@widgets/pim-work-history/main-form/main-form.vue';

/**
 * 工作履历编辑视图
 *
 * @export
 * @class PIMWORKHISTORYEditView
 * @extends {PIMWORKHISTORYEditViewBase}
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
export default class PIMWORKHISTORYEditView extends PIMWORKHISTORYEditViewBase { }
</script>