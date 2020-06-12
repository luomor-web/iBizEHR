<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEXPACCOUNTEditViewBase from './pimexpaccountedit-view-base.vue';

import view_form from '@widgets/pim-expaccount/main-form/main-form.vue';

/**
 * 费用台账编辑视图
 *
 * @export
 * @class PIMEXPACCOUNTEditView
 * @extends {PIMEXPACCOUNTEditViewBase}
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
export default class PIMEXPACCOUNTEditView extends PIMEXPACCOUNTEditViewBase { }
</script>