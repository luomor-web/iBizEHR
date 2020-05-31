<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMTITLECATALOGUEEditViewBase from './pimtitlecatalogueedit-view-base.vue';

import view_form from '@widgets/pim-title-catalogue/main-form/main-form.vue';

/**
 * 职称目录管理编辑视图
 *
 * @export
 * @class PIMTITLECATALOGUEEditView
 * @extends {PIMTITLECATALOGUEEditViewBase}
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
export default class PIMTITLECATALOGUEEditView extends PIMTITLECATALOGUEEditViewBase { }
</script>