/**
 * JDJSQR 部件模型
 *
 * @export
 * @class JDJSQRModel
 */
export default class JDJSQRModel {

  /**
  * 获取数据项集合
  *
  * @returns {any[]}
  * @memberof JDJSQRModel
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
        prop: 'pcmydjdmxid',
        dataType: 'GUID',
      },
      {
        name: 'srfmajortext',
        prop: 'pcmydjdmxname',
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
        name: 'jdksrq',
        prop: 'jdksrq',
        dataType: 'DATE',
      },
      {
        name: 'jdjsrq',
        prop: 'jdjsrq',
        dataType: 'DATE',
      },
      {
        name: 'pcmydjdmxid',
        prop: 'pcmydjdmxid',
        dataType: 'GUID',
      },
      {
        name: 'finished',
        prop: 'finished',
        dataType: 'INHERIT',
      },
      {
        name: 'pimpersonid',
        prop: 'pimpersonid',
        dataType: 'INHERIT',
      },
      {
        name: 'pimdistirbutionid',
        prop: 'pimdistirbutionid',
        dataType: 'PICKUP',
      },
      {
        name: 'isfinished',
        prop: 'isfinished',
        dataType: 'YESNO',
      },
      {
        name: 'pcmydjdmx',
        prop: 'pcmydjdmxid',
        dataType: 'FONTKEY',
      },
    ]
  }

}