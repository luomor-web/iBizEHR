<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMWORKHISTORYGREditViewBase from './pimworkhistorygredit-view-base.vue';

import view_form from '@widgets/pim-work-history/main-2-form/main-2-form.vue';

/**
 * 工作履历编辑视图
 *
 * @export
 * @class PIMWORKHISTORYGREditView
 * @extends {PIMWORKHISTORYGREditViewBase}
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
export default class PIMWORKHISTORYGREditView extends PIMWORKHISTORYGREditViewBase { }
</script>