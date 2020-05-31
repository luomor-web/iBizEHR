<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPersonAbilityDetailEditViewBase from './pimperson-ability-detail-edit-view-base.vue';

import view_form from '@widgets/pim-person-ability-detail/main-form/main-form.vue';

/**
 * 员工能力明细编辑视图
 *
 * @export
 * @class PIMPersonAbilityDetailEditView
 * @extends {PIMPersonAbilityDetailEditViewBase}
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
export default class PIMPersonAbilityDetailEditView extends PIMPersonAbilityDetailEditViewBase { }
</script>