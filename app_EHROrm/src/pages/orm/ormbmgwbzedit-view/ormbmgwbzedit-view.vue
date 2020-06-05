<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import ORMBMGWBZEditViewBase from './ormbmgwbzedit-view-base.vue';

import view_form from '@widgets/orm-bmgwbz/main-form/main-form.vue';

/**
 * 岗位编制明细
 *
 * @export
 * @class ORMBMGWBZEditView
 * @extends {ORMBMGWBZEditViewBase}
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
export default class ORMBMGWBZEditView extends ORMBMGWBZEditViewBase { }
</script>