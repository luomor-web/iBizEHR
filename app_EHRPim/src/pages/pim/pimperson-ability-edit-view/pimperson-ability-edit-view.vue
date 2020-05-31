<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMPersonAbilityEditViewBase from './pimperson-ability-edit-view-base.vue';

import view_form from '@widgets/pim-person-ability/main-form/main-form.vue';

/**
 * 员工能力编辑视图
 *
 * @export
 * @class PIMPersonAbilityEditView
 * @extends {PIMPersonAbilityEditViewBase}
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
export default class PIMPersonAbilityEditView extends PIMPersonAbilityEditViewBase { }
</script>