<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PimPersonEditView9Base from './pim-person-edit-view9-base.vue';

import view_form from '@widgets/pim-person/main2-form/main2-form.vue';

/**
 * 人员信息编辑视图（退休）
 *
 * @export
 * @class PimPersonEditView9
 * @extends {PimPersonEditView9Base}
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
export default class PimPersonEditView9 extends PimPersonEditView9Base { }
</script>