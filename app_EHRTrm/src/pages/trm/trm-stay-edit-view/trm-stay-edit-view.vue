<script lang='tsx'>
import { Component } from 'vue-property-decorator';
import TrmStayEditViewBase from './trm-stay-edit-view-base.vue';

import view_form from '@widgets/trm-stay/main-form/main-form.vue';

/**
 * 培训住宿
 *
 * @export
 * @class TrmStayEditView
 * @extends {TrmStayEditViewBase}
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
export default class TrmStayEditView extends TrmStayEditViewBase { }
</script>