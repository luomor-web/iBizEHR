<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import PIMEDUCATIONGREditViewBase from './pimeducationgredit-view-base.vue';

import view_form from '@widgets/pim-education/main-2-form/main-2-form.vue';

/**
 * 教育信息编辑视图
 *
 * @export
 * @class PIMEDUCATIONGREditView
 * @extends {PIMEDUCATIONGREditViewBase}
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
export default class PIMEDUCATIONGREditView extends PIMEDUCATIONGREditViewBase { }
</script>