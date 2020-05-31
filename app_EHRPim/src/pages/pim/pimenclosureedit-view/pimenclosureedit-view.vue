<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMENCLOSUREEditViewBase from './pimenclosureedit-view-base.vue';

import view_form from '@widgets/pim-enclosure/main-form/main-form.vue';

/**
 * 附件信息编辑视图
 *
 * @export
 * @class PIMENCLOSUREEditView
 * @extends {PIMENCLOSUREEditViewBase}
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
export default class PIMENCLOSUREEditView extends PIMENCLOSUREEditViewBase { }
</script>