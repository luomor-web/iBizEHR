<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStdglEditViewBase from './sal-stdgl-edit-view-base.vue';

import view_form from '@widgets/sal-stdgl/main-form/main-form.vue';

/**
 * 工龄工资标准编辑视图
 *
 * @export
 * @class SalStdglEditView
 * @extends {SalStdglEditViewBase}
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
export default class SalStdglEditView extends SalStdglEditViewBase { }
</script>