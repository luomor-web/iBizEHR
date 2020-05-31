<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMCONTRACTEditViewBase from './pimcontractedit-view-base.vue';

import view_form from '@widgets/pim-contract/main-form/main-form.vue';

/**
 * 合同信息编辑视图
 *
 * @export
 * @class PIMCONTRACTEditView
 * @extends {PIMCONTRACTEditViewBase}
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
export default class PIMCONTRACTEditView extends PIMCONTRACTEditViewBase { }
</script>