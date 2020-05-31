<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMSTAFFTYPEEditViewBase from './pimstafftypeedit-view-base.vue';

import view_form from '@widgets/pim-stafftype/main-form/main-form.vue';

/**
 * 员工类型编辑视图
 *
 * @export
 * @class PIMSTAFFTYPEEditView
 * @extends {PIMSTAFFTYPEEditViewBase}
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
export default class PIMSTAFFTYPEEditView extends PIMSTAFFTYPEEditViewBase { }
</script>