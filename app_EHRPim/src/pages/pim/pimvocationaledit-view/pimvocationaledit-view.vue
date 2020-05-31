<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMVOCATIONALEditViewBase from './pimvocationaledit-view-base.vue';

import view_form from '@widgets/pim-vocational/main-form/main-form.vue';

/**
 * 证书信息编辑视图
 *
 * @export
 * @class PIMVOCATIONALEditView
 * @extends {PIMVOCATIONALEditViewBase}
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
export default class PIMVOCATIONALEditView extends PIMVOCATIONALEditViewBase { }
</script>