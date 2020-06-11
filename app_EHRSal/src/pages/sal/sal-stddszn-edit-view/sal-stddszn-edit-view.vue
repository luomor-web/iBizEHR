<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import SalStddsznEditViewBase from './sal-stddszn-edit-view-base.vue';

import view_form from '@widgets/sal-stddszn/main-form/main-form.vue';

/**
 * 独生子女标准编辑视图
 *
 * @export
 * @class SalStddsznEditView
 * @extends {SalStddsznEditViewBase}
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
export default class SalStddsznEditView extends SalStddsznEditViewBase { }
</script>