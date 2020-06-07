/**
 * Main 部件模型
 *
 * @export
 * @class MainModel
 */
export default class MainModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof MainModel
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
        name: 'sxrq',
        prop: 'sxrq',
        dataType: 'DATE',
      },
      {
        name: 'pcmddsqdid',
        prop: 'pcmddsqdid',
        dataType: 'PICKUP',
      },
      {
        name: 'pcmddsqdname',
        prop: 'pcmddsqdname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgname',
        prop: 'ormorgname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'orgname',
        prop: 'orgname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormorgsectorname',
        prop: 'ormorgsectorname',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'orgsectorname',
        prop: 'orgsectorname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormyzw',
        prop: 'ormyzw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormdutyname',
        prop: 'ormdutyname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'ormygw',
        prop: 'ormygw',
        dataType: 'PICKUPDATA',
      },
      {
        name: 'ormpostname',
        prop: 'ormpostname',
        dataType: 'PICKUPTEXT',
      },
      {
        name: 'lx',
        prop: 'lx',
        dataType: 'TEXT',
      },
      {
        name: 'sfgbdd',
        prop: 'sfgbdd',
        dataType: 'YESNO',
      },
      {
        name: 'rzwj',
        prop: 'rzwj',
        dataType: 'LONGTEXT_1000',
      },
      {
        name: 'finishdd',
        prop: 'finishdd',
        dataType: 'YESNO',
      },
      {
        name: 'orgsectorid',
        prop: 'orgsectorid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormdutyid',
        prop: 'ormdutyid',
        dataType: 'PICKUP',
      },
      {
        name: 'ormpostid',
        prop: 'ormpostid',
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