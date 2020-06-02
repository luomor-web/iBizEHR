/**
 * JDGL2 部件模型
 *
 * @export
 * @class JDGL2Model
 */
export default class JDGL2Model {

	/**
	 * 是否是实体数据导出
	 *
	 * @returns {any[]}
	 * @memberof JDGL2GridMode
	 */
	public isDEExport: boolean = false;

	/**
	 * 获取数据项集合
	 *
	 * @returns {any[]}
	 * @memberof JDGL2GridMode
	 */
	public getDataItems(): any[] {
    if(this.isDEExport){
		  return [
      ]
    }else{
		  return [
        {
          name: 'ygw',
          prop: 'ygw',
          dataType: 'INHERIT',
        },
        {
          name: 'ygbh',
          prop: 'ygbh',
          dataType: 'INHERIT',
        },
        {
          name: 'jdshortname',
          prop: 'jdshortname',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'pcmydjdmxid',
          prop: 'pcmydjdmxid',
          dataType: 'GUID',
        },
        {
          name: 'pimdistirbutionid',
          prop: 'pimdistirbutionid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostid',
          prop: 'ormpostid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormpostname',
          prop: 'ormpostname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'ormorgsectorid',
          prop: 'ormorgsectorid',
          dataType: 'PICKUP',
        },
        {
          name: 'ormorgid',
          prop: 'ormorgid',
          dataType: 'PICKUP',
        },
        {
          name: 'syyf_color',
          prop: 'syyf_color',
          dataType: 'TEXT',
        },
        {
          name: 'syyf',
          prop: 'syyf',
          dataType: 'INT',
        },
        {
          name: 'jdksrq',
          prop: 'jdksrq',
          dataType: 'DATE',
        },
        {
          name: 'jdzzdzs',
          prop: 'jdzzdzs',
          dataType: 'PICKUPDATA',
        },
        {
          name: 'srfmajortext',
          prop: 'pcmydjdmxname',
          dataType: 'TEXT',
        },
        {
          name: 'srfdataaccaction',
          prop: 'pcmydjdmxid',
          dataType: 'GUID',
        },
        {
          name: 'srfkey',
          prop: 'pcmydjdmxid',
          dataType: 'GUID',
        },
        {
          name: 'ormdutyname',
          prop: 'ormdutyname',
          dataType: 'PICKUPTEXT',
        },
        {
          name: 'jdjsrq',
          prop: 'jdjsrq',
          dataType: 'DATE',
        },
        {
          name: 'ormdutyid',
          prop: 'ormdutyid',
          dataType: 'PICKUP',
        },
        {
          name: 'zzdzs',
          prop: 'zzdzs',
          dataType: 'INHERIT',
        },
        {
          name: 'checkstatus',
          prop: 'checkstatus',
          dataType: 'INHERIT',
        },
        {
          name: 'yzw',
          prop: 'yzw',
          dataType: 'INHERIT',
        },
        {
          name: 'shortname',
          prop: 'shortname',
          dataType: 'INHERIT',
        },
        {
          name: 'pimpersonname',
          prop: 'pimpersonname',
          dataType: 'INHERIT',
        },
        {
          name: 'pcmydjdmx',
          prop: 'pcmydjdmxid',
        },
      {
        name: 'n_ygbh_like',
        prop: 'n_ygbh_like',
        dataType: 'INHERIT',
      },
      {
        name: 'n_pimpersonname_like',
        prop: 'n_pimpersonname_like',
        dataType: 'INHERIT',
      },
      {
        name: 'n_zz_like',
        prop: 'n_zz_like',
        dataType: 'INHERIT',
      },
      {
        name: 'n_ormorgname_like',
        prop: 'n_ormorgname_like',
        dataType: 'PICKUPTEXT',
      },

        {
          name:'size',
          prop:'size'
        },
        {
          name:'query',
          prop:'query'
        },
        {
          name:'page',
          prop:'page'
        },
        {
          name:'sort',
          prop:'sort'
        },
        {
          name:'srfparentdata',
          prop:'srfparentdata'
        },
        // 前端新增修改标识，新增为"0",修改为"1"或未设值
        {
          name: 'srffrontuf',
          prop: 'srffrontuf',
          dataType: 'TEXT',
        },
      ]
    }
  }

}