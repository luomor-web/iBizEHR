/**
 * JDSQMX 部件模型
 *
 * @export
 * @class JDSQMXModel
 */
export default class JDSQMXModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JDSQMXModel
  */
  public getDataItems(): any[] {
    return [
      {
        name: 'srfwfmemo',
        prop: 'srfwfmemo',
        dataType: 'TEXT',
      },
      // 前端新增修改标识，新增为"0",修改为"1"或未设值
      {
        name: 'srffrontuf',
        prop: 'srffrontuf',
        dataType: 'TEXT',
      },
      {
        name: 'srfupdatedate',
        prop: 'updatedate',
        dataType: 'DATETIME',
      },
      {
        name: 'srforikey',
      },
      {
        name: 'srfkey',
        prop: 'pcmddsqdmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmddsqdmxname',
        dataType: 'TEXT',
      },
      {
        name: 'srftempmode',
      },
      {
        name: 'srfuf',
      },
      {
        name: 'srfdeid',
      },
      {
        name: 'srfsourcekey',
      },
      {
        name: 'pimdistirbutionid',
        prop: 'pimdistirbutionid',
        dataType: 'PICKUP',
      },
      {
        name: 'pimdistirbutionname',
        prop: 'pimdistirbutionname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'pcmddsqdid',
        prop: 'pcmddsqdid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormygw',
        prop: 'ormygw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'orgsectorname',
        prop: 'orgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'jdkssj',
        prop: 'jdkssj',
        dataType: 'DATE',
      },
      {
        name: 'jdjssj',
        prop: 'jdjssj',
        dataType: 'DATE',
      },
      {
        name: 'sxrq',
        prop: 'sxrq',
        dataType: 'DATE',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'orgid',
        prop: 'orgid',
        dataType: 'PICKUP',
      },
      {
        name: 'pcmddsqdmxid',
        prop: 'pcmddsqdmxid',
        dataType: 'GUID',
      },
      {
        name: 'pcmddsqdmx',
        prop: 'pcmddsqdmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}